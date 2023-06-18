#include <cmath>
#include <cstdio>
#include <iostream>
using namespace std;

class Student;
class Teacher;

class Person
{
private:
    int id;
    int age;

public:
    // Write necesssary functions
    void setID(int i) { id = i; }
    void setAge(int i) { age = i; }
    int getID() { return id; }
    int getAge() { return age; }
    virtual void printData() {};
};

class Teacher : public Person
{
private:
    int salary;

public:
    // Write necesssary functions
    void setSalary(int i) { salary = i; }
    int getSalary() { return salary; }
    void printData() { cout << "Teacher ID: " << getID() << " Age: " << getAge() << " Salary:" << salary << "\n"; }
};

class Student : public Person
{
private:
    double CGPA;

public:
    // Write necesssary functions
    void setCGPA(double i) { CGPA = i; }
    double getCGPA() { return CGPA; }
    void printData() { cout << "Student ID: " << getID() << " Age: " << getAge() << " CGPA:" << CGPA << "\n"; }
};

int main()
{

    Person *per[10];

    for (int i = 0; i < 5; i++)
    {
        Teacher *p = new Teacher;
        p->setID(i);
        p->setAge(40 + i);
        p->setSalary(p->getAge() * 10000);
        p->printData();

        per[i] = p;
    }

    for (int i = 5; i < 10; i++)
    {
        Student *p = new Student;
        p->setID(i);
        p->setAge(20 + i);
        p->setCGPA(3 + (1.0 / p->getID()));
        p->printData();

        per[i] = p;
    }

    cout << "\n\nThrough Base class pointer ... \n\n";

    for (int i = 0; i < 10; i++)
        per[i]->printData();

    return 0;
}

/* Output of main function

Teacher ID: 0 Age: 40 Salary:400000
Teacher ID: 1 Age: 41 Salary:410000
Teacher ID: 2 Age: 42 Salary:420000
Teacher ID: 3 Age: 43 Salary:430000
Teacher ID: 4 Age: 44 Salary:440000
Student ID: 5 Age: 25 CGPA:3.2
Student ID: 6 Age: 26 CGPA:3.16667
Student ID: 7 Age: 27 CGPA:3.14286
Student ID: 8 Age: 28 CGPA:3.125
Student ID: 9 Age: 29 CGPA:3.11111


Through Base class pointer ...

Teacher ID: 0 Age: 40 Salary:400000
Teacher ID: 1 Age: 41 Salary:410000
Teacher ID: 2 Age: 42 Salary:420000
Teacher ID: 3 Age: 43 Salary:430000
Teacher ID: 4 Age: 44 Salary:440000
Student ID: 5 Age: 25 CGPA:3.2
Student ID: 6 Age: 26 CGPA:3.16667
Student ID: 7 Age: 27 CGPA:3.14286
Student ID: 8 Age: 28 CGPA:3.125
Student ID: 9 Age: 29 CGPA:3.11111


*/
