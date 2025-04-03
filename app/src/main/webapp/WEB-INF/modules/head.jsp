<head>
	<meta charset="UTF-8">
	<title>${param.title}</title>
	<style>
/* General Body Styling */
body {
	margin: 0;
	padding: 0;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f4f7fc;  /* Light gray background */
	color: #333;  /* Dark text for contrast */
}

/* Navbar Styling */
.navbar {
	padding: 20px 30px;
	background-color: #2C3E50;  /* Darker blue-green for navbar */
	color: #fff;
	display: flex;
	justify-content: space-between;
	align-items: center;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);  /* Shadow for depth */
}

.navbar a {
	color: #fff;
	text-decoration: none;
	margin: 0 15px;
	font-size: 18px;  /* Increase text size for better readability */
	font-weight: 500;
	transition: color 0.3s ease;
}

.navbar a:hover {
	color: #FFD700;  /* Yellow hover effect to mimic the Snake's food */
}

.navbar h1 {
	font-size: 30px;  /* Increase size for the website title */
	font-weight: 700;
}

/* Form Styling */
form {
	background-color: #fff;
	padding: 30px;
	margin: 30px auto;
	max-width: 500px;
	border-radius: 8px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);  /* Shadow for form */
}

form h2 {
	text-align: center;
	color: #333;
}

form table {
	width: 100%;
	margin-top: 20px;
}

form td {
	padding: 8px 10px;
}

form input[type="text"],
form input[type="email"],
form input[type="password"] {
	width: 100%;
	padding: 10px;
	margin: 5px 0 15px 0;
	border: 1px solid #ddd;
	border-radius: 4px;
	font-size: 16px;
}

form input[type="submit"] {
	background-color: #4CAF50;  /* Snake's green */
	color: white;
	border: none;
	padding: 12px;
	width: 100%;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
	transition: background-color 0.3s;
}

form input[type="submit"]:hover {
	background-color: #45a049;  /* Slightly darker green on hover */
}

/* Match Result Styling */
.match-won {
	color: #4CAF50;  /* Green for wins */
	font-weight: bold;
}

.match-lost {
	color: #FF5733;  /* Red-orange for losses, fun and vibrant */
	font-weight: bold;
}

/* Table Styling */
table {
	width: 80%;
	margin: 30px auto;
	border-collapse: collapse;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);  /* Table shadow */
}

th, td {
	padding: 12px 20px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #2C3E50;  /* Darker background for header */
	color: white;
	font-weight: bold;
}

tr:hover {
	background-color: #f1f1f1;  /* Light hover effect for rows */
}

tr:nth-child(even) {
	background-color: #f9f9f9;  /* Zebra striping for table rows */
}

/* Responsive Design */
@media screen and (max-width: 768px) {
	.navbar {
		flex-direction: column;
		align-items: flex-start;
	}

	.navbar a {
		margin: 10px 0;
	}

	form {
		width: 90%;
		padding: 15px;
	}

	table {
		font-size: 14px;
		width: 100%;
	}
}

/* General Page Layout Fix */
.container {
	max-width: 1200px;
	margin: 0 auto;  /* Centers content */
	padding: 0 15px;
}

h2 {
	text-align: center;
	margin-top: 30px;
	color: #333;
}

.center-image {
	display: block;
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>
