/**
 * Чтобы создать пользователей, которые хранятся в базе
 * необходимо создать сущность пользователя. Чтобы отличать его
 * от системного, дадим ему название entity.MyUser.
 * На самом деле в аутентификации должен учавствовать тип
 * UserDetails, поэтому создадим класс MyUserDetails, который
 * реализует этот интерфейс и передадим этому класу MyUser
 * через конструктор.
 * Создадим MyUserDetailsService, который будет реализовать
 * интерфейс UserDetailsService, он требует реализовать только
 * один метод возвращающий объект типа UserDetails по переданному
 * ему имени. Откуда мы возьмем этот объект? Из базы данных возьмем
 * объект MyUser по имени и вернем объект типа UserDetails.
 * Так как MyUserDetails является UserDetails и содержит MyUser
 * Чтобы получить из базы MyUser, создадим MyUserRepository интерфейс,
 * расширяющий  JpaRepository спринговский интерфейс
 * JpaRepository<MyUser, Long> и объявим там метод
 * Optional<MyUser> findByName(String username)
 * Вспомним SecurityConfig - запрос "/user" и "/admin"
 * доступны только для прошедших аутентификфцию пользователей
 * имеющих соответствующие роли.
 * Для того чтобы поставить
 *
 *
 */
package ee.ivkhkdev.SpringSecurityDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}
}
