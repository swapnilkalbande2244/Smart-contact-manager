package com.first.firstproj.Controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
// import org.springframework.boot.actuate.web.exchanges.HttpExchange.Principal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.firstproj.Repos.ContactRepo;
import com.first.firstproj.Repos.repo;
import com.first.firstproj.entities.User;
import com.first.firstproj.entities.contacts;
import com.first.firstproj.helper.Message;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    // @Autowired
    // public Service service;

    @Autowired
    private repo Repo;

    @Autowired
    private ContactRepo contactRepo;
    
    @GetMapping("/dashboard")
    // @PreAuthorize("hasAuthority('ROLE_USER')")
    public String dashboard( Model model, Principal principal ){
        // System.out.println(service.getData()); 
        String userName = principal.getName();
        System.out.println(userName);
        User user = Repo.getUserByName(userName);
        model.addAttribute("user", user);
        System.out.println(user);

        // User user = Repo.findByEmail(userName);
        // String userName = principal.findByEmail();
        // System.out.println(user);
        // User u= service.getData();
        // model.addAttribute("Nname",u);
        return "normal/user_dashboard";
    }

    @GetMapping("/add-contact")
    public String addcontact(Model model){
        model.addAttribute("contacts", new contacts());
        return "normal/add-contact";
    }

    @PostMapping("/process-contact")
    public String addC(@ModelAttribute contacts contact, Principal principal, HttpSession session){
        // String name = principal.getName();
        // User user = this.Repo.getUserByName(name);

        // contact.setUser(user);

        // user.getcontacts().add(contact);
        // this.Repo.save(user);
        // System.out.println(contact);
        // return "normal/add-contact";

        try {
            String name = principal.getName();
        User user = this.Repo.getUserByName(name);
        
        contact.setUser(user);

        user.getcontacts().add(contact);
        this.Repo.save(user);
        System.out.println(contact);

        session.setAttribute("message", new Message("Contact Added Successfully","alert-success"));
        return "normal/add-contact";
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR" + e.getMessage());
            e.printStackTrace();
            session.setAttribute("message", new Message("Something went wrong !","alert-danger"));
            return "normal/add-contact";
        }
    }


    @GetMapping("/view-contact/{page}")
    public String view(@PathVariable("page") Integer page, Model m, Principal principal){
        String useName =principal.getName();
        User u =this.Repo.getUserByName(useName);
        Pageable pageable = PageRequest.of(page, 3);
        Page<contacts> c= this.contactRepo.findbyuserID(u.getId(),pageable);
        m.addAttribute("contacts", c);
        m.addAttribute("currentPage", page);
        m.addAttribute("totalPages", c.getTotalPages());
        return "normal/view-contact";
    }

    @GetMapping("/{cid}/contact-details")
    public String contactDetails(@PathVariable("cid")Integer cid , Model m){
        // System.out.println("This is CID"+cid);
        Optional<contacts> findById = this.contactRepo.findById(cid);
        contacts contacts = findById.get();
        m.addAttribute("contact", contacts);
        return "normal/contactDeatils";
    }

    @GetMapping("/delete/{cid}")
    public String deleteContact(@PathVariable("cid") Integer cid, Model m,HttpSession s, Principal p){
        contacts contacts = this.contactRepo.findById(cid).get();
        // contacts.setUser(null);
        // this.contactRepo.delete(contacts);
        // m.addAttribute(null, contacts);
        User user = this.Repo.getUserByName(p.getName());
        user.getcontacts().remove(contacts);
        this.Repo.save(user);
        s.setAttribute("message", new Message("Deleted Successfully !","alert-success"));
        return "redirect:/user/view-contact/0";
    }

    @GetMapping("/update-contact/{cid}")
    public String updateContact(@PathVariable("cid") Integer cid, Model m){
        contacts contacts = this.contactRepo.findById(cid).get();
        m.addAttribute("contact", contacts);
        return "normal/update-contact";

    }

    @PostMapping("/process-updatedcontact")
    public String processupdatedContact(@ModelAttribute contacts contact,Model m, Principal p){

        String name = p.getName();
        User userByName = this.Repo.getUserByName(name);
        contact.setUser(userByName);
        this.contactRepo.save(contact);
        System.out.println("CONTACT NAME :" + contact.getName());
        System.out.println("CONTACT PHONE :" + contact.getPhone());
        return "redirect:/user/" +contact.getCid()+"/contact-details" ;
    }

}
