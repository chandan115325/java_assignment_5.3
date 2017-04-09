 abstract class Employee {
	int empId;
	String empName;
	int total_leaves;
	double total_salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	abstract void calculate_balance_leaves();
	abstract boolean avail_leave(int no_of_leaves, char type_of_leave);
	abstract void calculate_salary();

}

class PermanentEmp extends Employee{
	
	int paid_leave, sick_leave, casual_leave,balance_leave,leave_taken,total_leave_entitlement,leave_adjusted,avail_leaves;
	double basic_salary, hra,pf,total_salary;
	
	public PermanentEmp(double basic_salary,String empName,int empId,int paid_leave,int sick_leave,int casual_leave,int total_leave_entitlement,int leave_adjusted)
	{	
		this.empName = empName;
		this.empId = empId; 
		this.paid_leave = paid_leave;
		this.sick_leave = sick_leave;
		this.casual_leave = casual_leave;
		this.total_leave_entitlement = total_leave_entitlement;
		this.leave_adjusted = leave_adjusted;
		this.basic_salary = basic_salary;
	}
	@Override
	void calculate_balance_leaves() {
		// TODO Auto-generated method stub
		
		this.balance_leave = this.total_leave_entitlement - this.leave_taken + this.leave_adjusted;
		
	}

	@Override
	boolean avail_leave(int no_of_leaves, char type_of_leave) {
		// TODO Auto-generated method stub
		
		this.avail_leaves = this.total_leaves-this.balance_leave;
		if(this.balance_leave > no_of_leaves)
		{	
			System.out.println("leaves are available."+this.avail_leaves);
		}
		else{
			System.out.println("leaves are not available.");
		}
		
		return false;
	}

	@Override
	void calculate_salary() {
		// TODO Auto-generated method stub
		this.pf = this.basic_salary*(12/100);
		this.hra = this.basic_salary*(50/100);
		this.total_salary = this.basic_salary + this.hra - this.pf;
		
		System.out.println("Details of Permanent employee :"+this.empName +" "+ "Employee ID :"+this.empId);
		System.out.println("Salary of the Permanent employee is :"+this.total_salary);
		
	}
	
	void print_leave_details(){
		
		System.out.println("Leaves details of Permanent employee :"+this.empName+ " "+ "Employee ID :"+this.empId);
		System.out.println("Total leaves are :"+ this.total_leave_entitlement);
		System.out.println("Total leaves are taken :"+this.leave_taken);
		System.out.println("balance leaves are :"+this.balance_leave);
		System.out.println("available leaves are :"+this.avail_leaves);
	}
	
}

class TemporaryEmp extends Employee{
	
	int paid_leave, sick_leave, casual_leave,balance_leave,leave_taken,total_leave_entitlement,leave_adjusted;
	double basic_salary, hra,pf,total_salary;
    int avail_leaves;
	

	public TemporaryEmp(double basic_salary,String empName,int empId,int paid_leave,int sick_leave,int casual_leave,int total_leave_entitlement,int leave_adjusted)
	{	
		this.empName = empName;
		this.empId = empId;
		this.paid_leave = paid_leave;
		this.sick_leave = sick_leave;
		this.casual_leave = casual_leave;
		this.total_leave_entitlement = total_leave_entitlement;
		this.leave_adjusted = leave_adjusted;
		
		this.basic_salary = basic_salary;
	}
	
	@Override
	void calculate_balance_leaves() {
		// TODO Auto-generated method stub
		
		this.balance_leave = this.total_leave_entitlement - this.leave_taken + this.leave_adjusted;
	}

	@Override
	boolean avail_leave(int no_of_leaves, char type_of_leave) {
		// TODO Auto-generated method stub
		
		this.avail_leaves = this.total_leaves-this.balance_leave;
		if(this.balance_leave > no_of_leaves)
		{	
			System.out.println("leave is available." +this.avail_leaves);
		}
		else{
			System.out.println("leaves are not available.");
		}
		
		return false;
	}

	@Override
	void calculate_salary() {
		// TODO Auto-generated method stub
		this.pf = this.basic_salary*(12/100);
		this.hra = this.basic_salary*(50/100);
		this.total_salary = this.basic_salary + this.hra - this.pf;
		System.out.println("Details of Temporary employee :"+"Name :"+this.empName +" "+ "Employee ID :"+this.empId);
		System.out.println("Salary of the Temporary employee is :"+this.total_salary);
	}
	
	void print_leave_details(){
		System.out.println("Leaves details of Temporary employee :"+"Name :"+this.empName+ " "+ "Employee ID :"+this.empId);
		System.out.println("Total leaves are :"+ this.total_leave_entitlement);
		System.out.println("Total leaves are taken :"+this.leave_taken);
		System.out.println("balance leaves are :"+this.balance_leave);
		System.out.println("available leaves are :"+this.avail_leaves);
	}
	
}
 class EmployeeRecord{
	 public static void main(String[] args)
	 {
		 PermanentEmp p = new PermanentEmp(27000.0,"Chandan",7,2,1,1,10,0);
		 p.calculate_balance_leaves();
		 p.calculate_salary();
		 p.print_leave_details();
		 p.avail_leave(0,'p');
		 
		 TemporaryEmp t = new TemporaryEmp(20000.0,"Chandan",7,2,1,1,10,0);
		 t.calculate_balance_leaves();
		 t.calculate_salary();
		 t.print_leave_details();
		 t.avail_leave(0,'t');
	 }
	
}