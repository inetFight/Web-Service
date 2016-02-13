package org.home.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/balance")
public class Resourse {

	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_XML)
	public List<UserData> getMessage(@PathParam("username") String username) {
		List<UserData> list = new ArrayList<UserData>();
		for (int i = 0; i < UserData.u.size(); i++) {
			if (UserData.u.get(i).getName().equalsIgnoreCase(username)) {
				list.add(UserData.u.get(i));
				break;
			}
		}
		return list;
	}

	@PUT
	@Path("/{username}/{balance}")
	@Produces(MediaType.APPLICATION_XML)
	public List<UserData> getMessage(@PathParam("username") String username, @PathParam("balance") int balance) {
		List<UserData> list = new ArrayList<UserData>();
		boolean check = true;
		for (int i = 0; i < UserData.u.size(); i++) {
			if (UserData.u.get(i).getName().equalsIgnoreCase(username)) {
				UserData.u.get(i).setBalance(balance);
				list.add(UserData.u.get(i));
				check = false;
			}
		}
		if (check == true) {
			UserData.u.add(new UserData(username, balance));
			for (int i = 0; i < UserData.u.size(); i++) {
				if (UserData.u.get(i).getName().equalsIgnoreCase(username)) {
					list.add(UserData.u.get(i));
				}
			}
		}
		return list;
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_XML)
	public List<UserData> getUsers() {
		return UserData.u;
	}
}