package com.conference.management.service;

import com.conference.management.entity.Role;
import com.conference.management.entity.User;
import com.conference.management.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    private IUserRepository userRepository;
    private IPaperAssignmentService paperAssignmentService;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(IUserRepository userRepository, BCryptPasswordEncoder passwordEncoder, IPaperAssignmentService paperAssignmentService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.paperAssignmentService = paperAssignmentService;
    }

    @Override
    public List<User> getViewersForAssignment(String field, int author_id) {
        return userRepository.getViewersForAssignment(field,author_id);
    }

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void setReviewerAssignmentEnable(User user) {
        if(user.isIs_reviewer_enable_to_review()){
            user.setIs_reviewer_enable_to_review(false);
        }
        else{
            user.setIs_reviewer_enable_to_review(true);
        }
        userRepository.update(user);
        if(user.isIs_reviewer_enable_to_review()){
            paperAssignmentService.paperAssignmentAfterEvaluate(user.getProfessions());
        }
    }

    @Override
    public User getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public User getByMail(String mail) {
        return userRepository.getByMail(mail);
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        User user= userRepository.getByMail(mail);
        Collection<Role> roleCollection=new ArrayList<Role>();
        roleCollection=user.getRoles();
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getMail(),user.getPassword(),
                mapRolesToAuthorities(roleCollection));
    }
}
