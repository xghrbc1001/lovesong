package net.viralpatel.contact.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.viralpatel.contact.form.Contact;
import net.viralpatel.contact.service.ContactService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ContactController {
	private static final Logger logger = Logger.getLogger(ContactController.class);
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
    public String index(
            @RequestParam(value = "locale", required = false) Locale locale,
            HttpServletRequest request,
            HttpServletResponse response) {

        return "index";
    }
	@RequestMapping(value = "mailIndex", method = RequestMethod.GET)
    public String mailIndex(
            @RequestParam(value = "locale", required = false) Locale locale,
            HttpServletRequest request,
            HttpServletResponse response) {

        return "kernel/mail/mail-index";
    }
	
	@RequestMapping(value = "ckeditor", method = RequestMethod.GET)
    public String ckeditor(
            @RequestParam(value = "locale", required = false) Locale locale,
            HttpServletRequest request,
            HttpServletResponse response) {

        return "ckeditor-demo";
    }
	@RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(
            @RequestParam(value = "locale", required = false) Locale locale,
            HttpServletRequest request,
            HttpServletResponse response,
            ModelMap modelMap) {
		
    	System.out.println("------------index------------------");
    	List<String> strlist = new ArrayList<String>();  
        for(int i=0;i<10;i++) {  
            strlist.add("list字符"+i);  
        }
        modelMap.put("contactListstrlist", strlist);  
        Map<String,String> map = new HashMap<String,String>();  
        for(int i=0;i<10;i++) {  
            map.put("zifu"+i, "map字符"+i);  
        }  
        map.put(null, "哦");  
        modelMap.put("map", map);
        List<Contact> objlist = contactService.listContact();
        modelMap.put("contactList", objlist);  
    	
        return "contact/contact-index";
    }
	@RequestMapping(value = "toAddContact", method = RequestMethod.GET)
	public String toAddContact(@ModelAttribute("contact")
	Contact contact, BindingResult result) {
		return "contact/contact-add";
	}
	
	@RequestMapping(value = "addContact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact")
	Contact contact, BindingResult result) {
		contactService.addContact(contact);
		
		return "redirect:/index";
	}
	@RequestMapping(value = "toEditContact/{contactId}")
	public String toEditContact(@PathVariable("contactId") Integer contactId, 
			//BindingResult result, 添加报错,原因是冲突
			Model view) {
		Contact contact = contactService.findContactById(contactId);
		view.addAttribute("contact", contact);
		return "contact/contact-edit";
	}
	@RequestMapping(value = "ediContact", method = RequestMethod.POST)
	public String ediContact(@ModelAttribute("contact")
	Contact contact, BindingResult result) {
		contactService.ediContact(contact);
		int i =5/0;
		
		//log it via log4j
		if(logger.isDebugEnabled()){
			logger.debug("--------------");
		}
		return "redirect:/index";
	}
	
	
	@RequestMapping("deleteContact/{contactId}")
	public String deleteContact(@PathVariable("contactId")
	Integer contactId) {

		contactService.removeContact(contactId);

		return "redirect:/index";
	}

}
