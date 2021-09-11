package com.blaj.UserManagement;

import com.blaj.UserManagement.dao.MarkDAOImpl;
import com.blaj.UserManagement.dao.UserDAOImpl;
import com.blaj.UserManagement.model.Dog;
import com.blaj.UserManagement.model.Mark;
import com.blaj.UserManagement.model.Review;
import com.blaj.UserManagement.model.User;
import com.blaj.UserManagement.service.MarkService;
import com.blaj.UserManagement.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UserManagementApplication{

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
		saveUsers();
	}

	private static void saveUsers() {
		UserService userService = new UserService(new UserDAOImpl());

		User user1 = new User("john", "john@org.com");
		user1.setAnimal(new Dog("Rex", 2));
		userService.saveUser(user1);

		User user2 = new User("marry", "marry@ne.com");
		user2.setAnimal(new Dog("Misi", 3));
		userService.saveUser(user2);

		User user3 = new User("paul", "paul@da.com");
		user3.setAnimal(new Dog("Azor", 3));
		userService.saveUser(user3);

//		saveMarks();

		System.out.println("Users saved!");

		User foundUser = userService.getUser(1);
		System.out.println(foundUser.toString());

		List<User> userList = userService.getAllUsers();
		System.out.println("Found " + userList.size() + " users in database");

		String givenName = "paul";
		List<User> foundUsers = userService.getAllUsersWithGivenName(givenName);
		if (foundUsers.isEmpty()) {
			System.out.println("No users with the name '" + givenName + "' found in database");
		} else {
			System.out.println("Found " + foundUsers.size() + " users with the name '" + givenName + "'.");
			String newEmail = "mamaliga@paprica.com";
			userService.setUserEmail(foundUsers.get(0).getId(), newEmail);
		}

		// merge oricum
//		int toDelete = 3;
//		userService.deleteUser(toDelete);
//		System.out.printf("Deleted user %d from database\n", toDelete);
//		System.out.println("Done!");
	}

	private static void saveMarks() {
		UserService userService = new UserService(new UserDAOImpl());
		for (int i = 1; i < 3; i++) {
			User user = userService.getUser(i);
			List<Mark> marks = new ArrayList<>();
			marks.add(new Mark(8, "romana"));
			marks.add(new Mark(9, "mate"));
			user.setMarks(marks);

			List<Review> reviews = new ArrayList<>();
			reviews.add(new Review("e o nota la romana" + i));
			marks.get(0).setReviews(reviews);

			MarkService markService = new MarkService(new MarkDAOImpl());

			for (Mark mark : marks) {
				markService.saveMark(mark);
			}
		}
	}

	public static void saveJson() {
		try {
			ObjectMapper mapper = new ObjectMapper();

			User theUser = mapper.readValue(new File("data/mock_data.json"), User.class);

			System.out.println(theUser);

			User newUser = new User("sergiu", "da@da.da");

			mapper.writeValue(new File("data/new_data.json"), newUser);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
