package org.unc.api.user;


import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByRoleAndIdNumber(Role role, String idNumber);
    User findByIdNumber(String idNumber);

}