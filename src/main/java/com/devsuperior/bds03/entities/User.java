package com.devsuperior.bds03.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "tb_user")	//UserDetails -> interface do spring Security
public class User implements UserDetails, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String email;
	private String password; 
	
	@ManyToMany(fetch = FetchType.EAGER) 
	@JoinTable(name = "tb_user_role",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	//Insere uma lista de perfis
	private Set<Role> roles = new HashSet<>(); 
	
	public User() {
		
	}

	public User(long id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public Set<Role> getRoles() {
		return roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}

	//Adicionado os quatros testes da conta do usuário 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// retorna uma coleção dos roles (Perfis do usuário) pega o nome do perfil e instancia no simplegranted
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList());
		//collect volta pra lista		
	}

	@Override
	public String getUsername() {
		
		return email;
	}

	@Override     
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override		
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override		
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override		
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
