

import model._
import model.PostAdded
import model.PostContent
import model.PostEdited
import org.scalatest.FunSuite


class AhoyTest extends FunSuite{


  lazy val post1 = PostId.generate()
  lazy val post2 = PostId.generate()
  lazy val posts = Posts.fromHistory(PostAdded(post1,PostContent("Jon","I am the BHL of code", "Brocoding is fun")), PostAdded(post2,PostContent("doba", "j'ai mal à la tête", "on ne ferra pas l'amour ce soir !")))


  test("The edit of an event should udpdate the version") {

    val Post(_, content, currentversion) = posts.get(post1).get
    assert(posts.apply(PostEdited(post1,content)).get(post1).get.version > currentversion)


  }
}
