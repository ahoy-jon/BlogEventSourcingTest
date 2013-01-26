package model

import java.util.UUID


case class PostContent(author: String, title: String, content: String)

case class PostId(uuid: UUID)
object PostId {
  def generate(): PostId = PostId(UUID.randomUUID())

  def fromString(s: String): Option[PostId] = s match {
    case PostIdRegex(uuid) => {
      import util.control.Exception._
      catching(classOf[RuntimeException]) opt { PostId(UUID.fromString(uuid)) }
    }
    case _                 => None
  }

  private val PostIdRegex = """PostId\(([a-fA-F0-9-]{36})\)""".r
}


trait PostEvent {
  def postId:PostId
}

case class PostAdded(postId:PostId, content: PostContent) extends PostEvent

case class PostEdited(postId: PostId, content: PostContent) extends PostEvent

case class PostDeleted(postId: PostId) extends PostEvent

