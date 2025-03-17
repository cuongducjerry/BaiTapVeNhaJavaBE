package vn.com.t3h.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.t3h.entity.IdentityCardEntity;
import vn.com.t3h.entity.RoleEntity;
import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.service.IdentityCardService;
import vn.com.t3h.service.RoleService;
import vn.com.t3h.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private final IdentityCardService identityCardService;

    public UserController(
            UserService userService,
            RoleService roleService,
            IdentityCardService identityCardService) {
        this.userService = userService;
        this.roleService = roleService;
        this.identityCardService = identityCardService;
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        List<UserEntity> list = userService.getUsers();
        model.addAttribute("users", list);
        return "list-users";
    }

    @GetMapping("/{id}")
    public String getUserDetail(Model model, @PathVariable(name="id") long id) {
        UserEntity user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "detail-user";
    }

    @GetMapping("/create")
    public String getCreateUser(Model model) {
        model.addAttribute("newUser", new UserEntity());
        return "add-user";
    }

    @PostMapping("/create")
    public String postCreateUser(Model model,
                                 @RequestParam(value = "username", required = false) String username,
                                 @RequestParam(value = "password", required = false) String password,
                                 @RequestParam(value = "address", required = false) String address,
                                 @RequestParam(value = "phone", required = false) String phone,
                                 @RequestParam(value = "email", required = false) String email,

                                 @RequestParam(value = "roles", required = false) String roleNames,
                                 @RequestParam(value = "identityCard", required = false) String identityCardNumber) {

        // Tìm danh sách RoleEntity
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setPhone(phone);
        user.setEmail(email);

        RoleEntity role = this.roleService.findByRoleNameIn(roleNames);
        Set<RoleEntity> setR = new HashSet<RoleEntity>();
        setR.add(role);

        user.setRoles(setR);
        // Lưu user vào database
        long userId = userService.addUser(user);
        UserEntity newUser = userService.findById(userId);


        // Nếu có IdentityCard, tạo mới và gán vào user
        IdentityCardEntity identityCard = null;
        if (identityCardNumber != null && !identityCardNumber.isEmpty()) {
            identityCard = new IdentityCardEntity();
            identityCard.setIdentityNumber(identityCardNumber);
            identityCard.setUser(newUser);
            long identityCardId = this.identityCardService.addIdentityCard(identityCard);
            IdentityCardEntity identityCardEntity2 = this.identityCardService.findIdentityById(identityCardId);
            newUser.setIdentityCard(identityCard);
        }
        this.userService.updateUserWithIdentity(newUser);

        return "redirect:/api/users/";
    }

    @GetMapping("/update/{id}") // GET
    public String getUpdateUser(Model model, @PathVariable(name="id") long id) {
        UserEntity currentUser = userService.findById(id);
        model.addAttribute("newUser", currentUser);
        return "update-user";
    }

    @PostMapping("/update")
    public String postUpdateUser(Model model, @ModelAttribute("newUser") UserEntity user) {
        UserEntity currentUser = this.userService.findById(user.getId());
        if (currentUser != null) {
            currentUser.setUsername(user.getUsername());
            currentUser.setPassword(user.getPassword());
            currentUser.setEmail(user.getEmail());
            currentUser.setPhone(user.getPhone());
            currentUser.setAddress(user.getAddress());
            this.userService.updateUser(currentUser);
        }
        return "redirect:/api/users/";
    }

    @GetMapping("/delete/{id}")
    public String getDeleteUser(Model model, @PathVariable(name="id") long id) {
        model.addAttribute("id", id);
        model.addAttribute("newUser", new UserEntity());
        return "delete-user";
    }

    @PostMapping("/delete")
    public String postDeleteUser(Model model, @ModelAttribute("newUser") UserEntity user) {
        this.userService.deleteUser(user.getId());
        return "redirect:/api/users/";
    }

    @PostMapping("/search-target")
    public String postSearchTarget(
            Model model,
            @RequestParam("username") String username,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            @RequestParam("address") String address,
            @RequestParam("identityCard") String identityCard,
            @RequestParam("roles") List<String> roleNames){

        System.out.println("---------1-----------");
        for(String roleName:roleNames){
            System.out.println(roleName);
        }
        System.out.println("---------1-----------");

        List<UserEntity> users = this.userService.listUserWithTarget(username, phone, email, address, identityCard, roleNames);

        System.out.println("-------------------------------------------------------------");
        for(UserEntity user : users){
            System.out.println(user);
        }
        System.out.println("-------------------------------------------------------------");

        model.addAttribute("users", users);
        return "list-users";

    }

}
