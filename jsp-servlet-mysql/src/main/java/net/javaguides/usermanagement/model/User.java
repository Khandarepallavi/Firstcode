package net.javaguides.usermanagement.model;

import javax.servlet.http.Part;

import com.mysql.cj.jdbc.Blob;

public class User {
	
		protected int id;
		protected String vendor_code;
	    protected String industry;
		protected String category;
		
		protected String sub_category;
		protected String country;
		protected String state;
		protected String city;
		protected String company_name;
		protected String address;
		protected int pin;
		
		protected String contact_person;
		protected String email;
        protected String contact_number;
		protected String landline;
		
		protected String gst_number;
		protected String web_site;
		protected String type_of_business;
		
		protected Blob product_catalouge;
		
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getVendor_code() {
			return vendor_code;
		}
		public void setVendor_code(String vendor_code) {
			this.vendor_code = vendor_code;
		}
		public String getIndustry() {
			return industry;
		}
		public void setIndustry(String industry) {
			this.industry = industry;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getSub_category() {
			return sub_category;
		}
		public void setSub_category(String sub_category) {
			this.sub_category = sub_category;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCompany_name() {
			return company_name;
		}
		public void setCompany_name(String company_name) {
			this.company_name = company_name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public int getPin() {
			return pin;
		}
		public void setPin(int pin) {
			this.pin = pin;
		}
		
		public String getContact_person() {
			return contact_person;
		}
		public void setContact_person(String contact_person) {
			this.contact_person = contact_person;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getContact_number() {
			return contact_number;
		}
		public void setContact_number(String contact_number) {
			this.contact_number = contact_number;
		}
		public String getLandline() {
			return landline;
		}
		public void setLandline(String landline) {
			this.landline = landline;
		}
		
		public String getGst_number() {
			return gst_number;
		}
		public void setGst_number(String gst_number) {
			this.gst_number = gst_number;
		}
		public String getWeb_site() {
			return web_site;
		}
		public void setWeb_site(String web_site) {
			this.web_site = web_site;
		}
		public String getType_of_business() {
			return type_of_business;
		}
		public void setType_of_business(String type_of_business) {
			this.type_of_business = type_of_business;
		}
		
		
		
		
		
		public Blob getProduct_catalouge() {
			return product_catalouge;
		}
		public void setProduct_catalouge(Blob product_catalouge) {
			this.product_catalouge = product_catalouge;
		}
		public User() {
			
		}
		public User(String industry, String category, String sub_category, String country, String state,
				String city,String company_name, String address,  int pin, String contact_person,String email,String contact_number, String landline,
				String gst_number, String web_site, String type_of_business, Blob product_catalouge) {
			super();
			
			
			this.industry = industry;
			this.category = category;
			this.sub_category = sub_category;
			this.country = country;
			this.state = state;
			this.city = city;
			this.company_name = company_name;
			this.address = address;
			this.pin = pin;
			
			this.contact_person = contact_person;
			this.email = email;
			this.contact_number = contact_number;
			this.landline = landline;
			
			this.gst_number = gst_number;
			this.web_site = web_site;
			this.type_of_business = type_of_business;
		
			this.product_catalouge = product_catalouge;
			
			
		}
		public User(int id,String vendor_code, String industry, String category, String sub_category,  String country,String state, String city,String company_name,
				String address, int pin, String contact_person,  String email,String contact_number,
				String landline, String gst_number, String web_site, String type_of_business,
				Blob product_catalouge) {
			super();
			this.id=id;
			this.vendor_code = vendor_code;
			this.industry = industry;
			this.category = category;
			this.sub_category = sub_category;
			this.country = country;
			this.state = state;
			this.city = city;
			this.company_name = company_name;
			this.address = address;
			this.pin = pin;
			this.contact_person = contact_person;
			this.email = email;
			this.contact_number = contact_number;
			this.landline = landline;
			this.gst_number = gst_number;
			this.web_site = web_site;
			this.type_of_business = type_of_business;
			
			this.product_catalouge = product_catalouge;
			
			
		}
		public User(int id, String vendor_code, String industry, String category, String sub_category,
				String country, String state, String city, String company_name, String address, int pin,
				String contact_person, String email, String contact_number, String landline, String gst_number,
				String web_site, String type_of_business, Part product_catalouge) {
			// TODO Auto-generated constructor stub
		}
		
		public User(String industry2, String category2, String sub_category2, String country2, String state2,
				String city2, String company_name2, String address2, int pin2, String contact_person2, String email2,
				String contact_number2, String landline2, String gst_number2, String web_site2,
				String type_of_business2, java.sql.Blob product_catalouge2) {
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		public User(String industry2, String category2, String sub_category2, String country2, String state2,
				String city2, String company_name2, String address2, int pin2, String contact_person2, String email2,
				String contact_number2, String landline2, String gst_number2, String web_site2,
				String type_of_business2, Part product_catalouge2) {
			// TODO Auto-generated constructor stub
		}
		public User(int id, String vendor_code, String industry, String category, String sub_category,
				String country, String state, String city, String company_name, String address, int pin,
				String contact_person, String email, String contact_number, String landline, String gst_number,
				String web_site, String type_of_business, java.sql.Blob product_catalouge) {
			// TODO Auto-generated constructor stub
		}
		public java.sql.Blob getfile() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		

	
		
		
		
		
		
	
	
		

		
		
		
		
	}


