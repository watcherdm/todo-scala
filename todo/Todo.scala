import scalax.io._;
 
object Todo {
  class TodoItem(t: String) {
    var done: Boolean = false;
    var text: String = t;
    override def toString(): String = {
      var complete = " ";
      if (done) {
        complete = "X";
      }
      return "[" + complete + "] " + text;
    }
  }
  def printTodos(todo: List[TodoItem]) {
    todo.foreach(println);
  }
  def printMenu(menu: List[String]) {
    menu.foreach(println);
  }
  def main(args: Array[String]) {
    var todo: List[TodoItem] = List();
    var menu = List("[A]dd", "[C]omplete", "[R]emove", "[Q]uit");
    var exit = false;
    while (!exit) {
      println("Hello Todo Application");
      println("----------------------");
      printTodos(todo);
      println("----------------------");
      printMenu(menu);
      val userInput = readLine("TODO:>");
      if (userInput == "Q") {
        exit = true;
      } else if (userInput == "A") {
        val itemVal = readLine("TODO DESCRIPTION:>");
        val todoItem = new TodoItem(itemVal);
        todo = List.concat(todo, List(todoItem));
      } else if (userInput == "C") {
        print("TODO INDEX:>");
        val itemIndex = readInt();
        var currentTodo = todo.apply(itemIndex);
        currentTodo.done = true;
      } else if (userInput == "R") {
        print("TODO INDEX:>");
        val itemIndex = readInt();
        var currentTodo = todo.apply(itemIndex);
        todo = todo.filter(x => x != currentTodo);
      } else {
        println("Command not found " + userInput);
      }
    }
  }
}
