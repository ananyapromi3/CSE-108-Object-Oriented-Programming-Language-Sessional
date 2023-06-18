#include <iostream>
#include <cstring>
#include <cstdlib>
using namespace std;

class Student
{
    char *name;
    int ID;
    double credit, CGPA;

public:
    Student(char s[], int id, double crdt, double cgpa)
    {
        name = (char *)malloc((strlen(s) + 1) * sizeof(char));
        strcpy(name, s);
        ID = id;
        credit = crdt;
        CGPA = cgpa;
    }

    ~Student()
    {
        if(name)
            free(name);
    }

    void showInfo()
    {
        cout << "Name: " << name << ", ";
        cout << "Id: " << ID << ", ";
        cout << "Credit Completed: " << credit << ", ";
        cout << "CGPA: " << CGPA << endl;
    }

    void change(char s[])
    {
        if(name)
            free(name);
        name = (char *)malloc((strlen(s) + 1) * sizeof(char));
//        if (name[strlen(s)])
//            free(name + strlen(s));
        strcpy(name, s);
    }

    void change(int id)
    {
        ID = id;
    }

    void addTermResult(double crdt, double cgpa)
    {
        CGPA = ((CGPA * credit) + (cgpa * crdt)) / (credit + crdt);
        credit += crdt;
    }
};

class Batch
{
    Student *students;
    int number;

public:
    Batch()
    {
        students = (Student *)malloc(1200 * sizeof(Student));
        number=0;
    }

    ~Batch()
    {
        free(students);
    }

    void addStudent(Student &s)
    {
        students[number]=s;
        number++;
    }

    void showAllStudents()
    {
        int i;
        for(i=0;i<number;i++)
            students[i].showInfo();
    }
};

int main()
{
    // Part 1
    // A student class holds the information of the student name, id, credit earned so far, and cumulative gpa (cgpa)
    // The name of a student is stored using malloc, which will be freed during destruction
    Student s1("Tamim Iqbal", 1905131, 39, 3.56);
    Student s2("Liton Das", 1905150, 39, 3.52);
    s1.showInfo();
    cout << "Changing the name of s1" << endl;
    // During changing the name, you should reallocate memory of the new name and free the previously allocated memory
    s1.change("Tamim Iqbal Khan");
    s1.showInfo();
    cout << "Changing the id of s2" << endl;
    s2.change(1905149);
    s2.showInfo();
    cout << "Adding a term result of s1" << endl;
    // The first argument of addTermResult is the credit earned in a term and second one is the gpa obtained in that term
    s1.addTermResult(19, 3.85);
    s1.showInfo();
    // Part 2
    // Batch contains a list of students
    // During construction, a Batch object allocates dynamic memory for 1200 students using malloc. The memory will be freed during destruction

    Batch b;
    b.addStudent(s1);
    b.addStudent(s2);
    cout << "Printing the list of students of the batch b" << endl;
    b.showAllStudents();

    return 0;
}
