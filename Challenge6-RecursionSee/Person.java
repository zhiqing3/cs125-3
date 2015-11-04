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
	if (this.child1!=null && this.child2!=null ) return 1+this.child1.count()+this.child2.count();
	else if (this.child1!=null) return 1+this.child1.count();
	else if (this.child2!=null) return 1+this.child2.count();
	else return 1;
}
public int countGrandChildren() // but not greatGrandChildren
{
	//YOUR CODE HERE
	throw new IllegalArgumentException("Not Yet Implemented");
}

public int countMaxGenerations()
{
	//YOUR CODE HERE
	throw new IllegalArgumentException("Not Yet Implemented");   
}

public int countGender(char gen)
{
	//YOUR CODE HERE
	throw new IllegalArgumentException("Not Yet Implemented");
}


public Person search(String name, int maxGeneration)
{
	//YOUR CODE HERE
	throw new IllegalArgumentException("Not Yet Implemented");
}

} // end of class
