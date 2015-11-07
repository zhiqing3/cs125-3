//UIUC CS125 FALL 2014 MP. File: Person.java, CS125 Project: Challenge6-RecursionSee, Version: 2015-10-26T21:57:48-0500.725586880
/**
 * @author qilezhi2
 *
 */
public class Person
{
private final String name;
private final int age;
private final char gender;
private final Person child1; //left child
private final Person child2; //right child

public Person(String name, int age, char gender, Person c1, Person c2)
{
    this.name=name;
    this.age=age;
    this.gender=gender;
    this.child1 = c1;
    this.child2 = c2;
}

public String toString()
{
    return name+"*"+age+"*"+gender;
}

public String getName() 
{
	return name;
}

public int getAge() 
{
	return age;
}

public char getGender() 
{
	return gender;
}

public boolean equals(Person p)
{
	return (this.name.equals(p.name)) &&
			(this.age==p.age) &&
			(this.gender==p.gender);
}


public void print() 
{
   System.out.println(this);
   if(child1 != null)
       child1.print();
   if(child2 != null)
       child2.print();
   
}

public int count() // total person count including this object
{
	if (this.child1!=null && this.child2!=null) return 1+this.child1.count()+this.child2.count();
	else if (this.child1!=null) return 1+this.child1.count();
	else if (this.child2!=null) return 1+this.child2.count();
	else return 1;
}

public int countChildren(int depth) { // Write a more general method
	if (depth==1) return 1; // the first generation is the person himself.
	else {
		if (this.child1!=null && this.child2!=null) 
			return this.child1.countChildren(depth-1)+this.child2.countChildren(depth-1);
		else if (this.child1!=null) return this.child1.countChildren(depth-1);
		else if (this.child2!=null) return this.child2.countChildren(depth-1);
		else return 0;
	}
}

public int countGrandChildren() // but not greatGrandChildren
{
//	int count=0;
//	if (this.child1!=null) {
//		if (this.child1.child1!=null) count++; 
//		if (this.child1.child2!=null) count++;
//	}
//	if (this.child2!=null) {
//		if (this.child2.child1!=null) count++; 
//		if (this.child2.child2!=null) count++;
//	}
//	return count;
	
	return countChildren(3);
}

public int countMaxGenerations()
{
	if (this.child1!=null && this.child2!=null) return 1
			+ Math.max(this.child1.countMaxGenerations(),this.child2.countMaxGenerations());
	else if (this.child1!=null) return 1+this.child1.countMaxGenerations();
	else if (this.child2!=null) return 1+this.child2.countMaxGenerations();
	else return 1;  
}

public int countGender(char gen)
{
	int result=0;
	// Count the gender for its offsprings.
	if (this.child1!=null && this.child2!=null) result = this.child1.countGender(gen)+this.child2.countGender(gen);
	else if (this.child1!=null) result = this.child1.countGender(gen);
	else if (this.child2!=null) result = this.child2.countGender(gen);
	else result = 0;
	if (this.gender==gen) result++; // If the person is that gender,
	return result; // If not,
}


public Person search(String name, int maxGeneration)
{
	if (maxGeneration<=0) return null;
	else {
		if (this.name.equals(name)) return this; // If the person's name equals to that string, we are done.
		else {
			if (this.child1!=null && this.child2!=null) {
				if (this.child1.search(name, maxGeneration-1)!=null) return this.child1.search(name, maxGeneration-1);
				if (this.child2.search(name, maxGeneration-1)!=null) return this.child2.search(name, maxGeneration-1);
				else return null; // If nothing is found, return null.
			}
			else if (this.child1!=null) return this.child1.search(name, maxGeneration-1);
			else if (this.child2!=null) return this.child2.search(name, maxGeneration-1);
			else return null;
		}
	}
}

} // end of class
