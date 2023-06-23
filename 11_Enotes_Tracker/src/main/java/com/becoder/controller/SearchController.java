/*
 * package com.becoder.controller;
 * 
 * import java.security.Principal; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.orm.hibernate5.HibernateTemplate; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.becoder.dao.NotesDao; import com.becoder.dao.UserDao; import
 * com.becoder.entity.Notes; import com.becoder.entity.User;
 * 
 * @RestController public class SearchController {
 * 
 * @Autowired private HibernateTemplate hibernateTemplate;
 * 
 * @Autowired private UserDao userDao;
 * 
 * @Autowired private NotesDao notesDao;
 * 
 * // Search Handler
 * 
 * @RequestMapping(path = "/search/{query}") public ResponseEntity<?>
 * search(@PathVariable("query") String query, Principal principal) {
 * 
 * System.out.println(query); User user = hibernateTemplate.get(User.class,
 * principal.getName());
 * 
 * List<Notes> notes = this.notesDao.findByTitleContainingAndUser(query, user);
 * 
 * return ResponseEntity.ok(notes); }
 * 
 * }
 */