package in.code.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.code.db.JdbcUtil;
import in.code.entity.User;

public class UserDaoImpl implements IUserDao {
	private Connection con;

	public boolean userRegister(User us) {

		boolean flag = false;
		try {
			con = JdbcUtil.getJdbcConnection();
			PreparedStatement ps = con.prepareStatement("insert into user(name,email,phno,password) values(?,?,?,?)");
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhno());
			ps.setString(4, us.getPassword());
			int rowUpdated = ps.executeUpdate();
			if (rowUpdated == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return flag;
	}

	public User login(String email, String password) {
		User us = null;
		try {
			con = JdbcUtil.getJdbcConnection();
			PreparedStatement ps = con.prepareStatement("select * from user where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				us = new User();
				us.setId(rs.getInt(1));
				us.setName(rs.getString(2));
				us.setEmail(rs.getString(3));
				us.setPhno(rs.getString(4));
				us.setPassword(rs.getString(5));
				us.setAddress(rs.getString(6));
				us.setLandmark(rs.getString(7));
				us.setCity(rs.getString(8));
				us.setState(rs.getString(9));
				us.setPincode(rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return us;
	}

	public boolean checkpassword(int id, String password) {
		boolean f = false;
		try {
			con = JdbcUtil.getJdbcConnection();
			PreparedStatement ps = con.prepareStatement("select * from user where id = ? and password = ?");
			ps.setInt(1, id);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				f = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean updateProfile(User us) {
		boolean f = false;
		try {
			con = JdbcUtil.getJdbcConnection();
			PreparedStatement ps = con.prepareStatement("update user set name = ? ,email = ? ,phno= ? where id = ? ");
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhno());
			ps.setInt(4, us.getId());
			int rowAffected = ps.executeUpdate();
			if (rowAffected >= 1) {
				f = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean checkUser(String email) {
		boolean f = false;
		try {
			con = JdbcUtil.getJdbcConnection();
			PreparedStatement ps = con.prepareStatement("select * from user where email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				f = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
	}

}
