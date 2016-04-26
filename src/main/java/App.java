import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) ->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("tamagotchiName");
      Tamagotchi testPet = new Tamagotchi(name);
      ArrayList<Tamagotchi> pets = request.session().attribute("pets");
      if(pets == null){
        pets = new ArrayList<Tamagotchi>();
        request.session().attribute("pets", pets);
      }

      pets.add(testPet);

      model.put("pets", request.session().attribute("pets"));
      model.put("template", "templates/results.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
