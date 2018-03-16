package com.dhananjay;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.mysql.jdbc.Connection;

import bean.DateNTime;
import connection.ConnectionProvider;

public class Verify {
	static Connection connection = null;
	PreparedStatement preparedStatement = null;

	public String getVerify(DateNTime dateNTime) {
		connection = (Connection) ConnectionProvider.getConn();
		boolean flag = false;
		// Calendar calendar=Calendar.getInstance();
		// Date date=calendar.getTime();
		// System.out.println(date);

		try {
			preparedStatement = connection.prepareStatement("select * from datecheck ");
			// preparedStatement.setString(1,dateNTime.getStartMonth());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String startM = resultSet.getString("startMonth");
				int startMonthdb = Integer.parseInt(startM);

				String endM = resultSet.getString("endMonth");
				int endMonthdb = Integer.parseInt(endM);

				String startY = resultSet.getString("startYear");
				int startYeardb = Integer.parseInt(startY);

				String endY = resultSet.getString("endYear");
				int endYeardb = Integer.parseInt(endY);

				// System.out.println(endYeardb);
				// System.out.println(dateNTime.getEndMonth());
				int startMonth = Integer.parseInt(dateNTime.getStartMonth());
				int endMonth = Integer.parseInt(dateNTime.getEndMonth());
				int startYear = Integer.parseInt(dateNTime.getStartYear());
				int endYear = Integer.parseInt(dateNTime.getEndYear());
				if ((startMonth <= 12 && startMonth > 0) && (endMonth > 0 && endMonth <= 12)) {

					if ((startYeardb == endYear) || (endYeardb == startYear)) {

						if ((startMonthdb > endMonth) || (endMonthdb < startMonth)) {
							System.out.println("right");
							flag = true;

						} else {
							flag = false;
							System.out.println("fail");
						}

					} else if ((startYeardb > endYear) || (endYeardb < startYear)) {
						flag = true;
					} else {

						flag = false;
						System.out.println("fail");
						return "fail";
					}
				}

				else {
					flag = false;
					return "Please enter correct month";
				}
			}
			if (flag) {
				PreparedStatement preparedStatement2 = connection
						.prepareStatement("insert into datecheck values(?,?,?,?)");
				preparedStatement2.setString(1, dateNTime.getStartMonth());
				preparedStatement2.setString(2, dateNTime.getStartYear());
				preparedStatement2.setString(3, dateNTime.getEndMonth());
				preparedStatement2.setString(4, dateNTime.getEndYear());
				preparedStatement2.executeUpdate();
				return "success";
			} else {
				return "fail";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "fail";

	}

}
