/**
 * 
 */
package com.sivalabs.sgdemo

import com.sivalabs.sgdemo.entities.User
import com.sivalabs.sgdemo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

import javax.annotation.PostConstruct;

/**
 * @author user
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableConfigurationProperties
class Application {

	@Autowired
	UserRepository userRepository

	static main(args) {
		println 'Hello Spring Groovy Sample'
		SpringApplication.run(Application.class, args)
	}

	@PostConstruct
	void init(){
		try {
			userRepository.deleteAll();
			userRepository.save(new User(name:'admin', email: 'admin@gmail.com',password: 'admin'))
			userRepository.save(new User(name:'siva', email: 'siva@gmail.com',password: 'siva'))

		}catch (any){
			any.printStackTrace()
		}

	}

}

@Controller
class HomeController
{
	@Autowired
	AppConfig appConfig

	@RequestMapping("/")
	String home(Model model){
		model.addAttribute('appName', appConfig.name)
		model.addAttribute('appDescription', appConfig.description)
		'home.html'
	}
}
