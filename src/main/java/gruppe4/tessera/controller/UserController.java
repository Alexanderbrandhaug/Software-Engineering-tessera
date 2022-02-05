package gruppe4.tessera.controller;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import gruppe4.tessera.service.UserService;
import gruppe4.tessera.model.User;

@Controller // This means that this class is a Controller
@RequestMapping(path="/tessera") // This means URL's start with /tessera (after Application path)
public class UserController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private UserService userService;

  @PostMapping(path="/add/user") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam String email, @RequestParam String phoneNumber
      , @RequestParam boolean isAdmin, @RequestParam String password) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    User n = new User();
    if (userService.findUserByEmail(email) == null){
      n.setName(name);
      n.setEmail(email);
      n.setAdmin(isAdmin);
      n.setPhoneNumber(phoneNumber);
      n.setPassword(password);
      userService.saveUser(n);
      return "Saved";
    }
    return "Email already exists";
  }


  @GetMapping(path="/users")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with all users
    return userService.getAllUsers();
  }


  @GetMapping(path="/user")
  @Transactional
  public @ResponseBody String deleteUserByEmail(@RequestParam String email){
    if(userService.findUserByEmail(email) != null){
      userService.deleteUserByEmail(email);
      return "User successfully deleted";
    }
    return "There does not exist a user with email: " + email;
  }

  @GetMapping(path="/user/{email}")
  @Transactional
  public @ResponseBody User getUserByEmail(@PathVariable String email){
    return userService.findUserByEmail(email);
  }  
}