import model._
import model.PostAdded
import model.PostContent
import model.PostEdited


object MyApp extends App {


  val post1 = PostId.generate()
  val post2 = PostId.generate()

  val posts = Posts.fromHistory(PostAdded(post1,PostContent("Jon","I am the BHL of code", "Brocoding is fun")), PostAdded(post2,PostContent("doba", "j'ai mal à la tête", "on ne ferra pas l'amour ce soir !")))


  def printstate(posts: Posts) = {
   posts.mostRecent(2).foreach(println)
  }

  printstate(posts)
  printstate(posts.apply(PostEdited(post2, PostContent("doba", "ça va mieux", "mais cela sera chaud pour ce soir quand même ! "))))

  printstate(posts)


}




