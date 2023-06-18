#include <iostream>
#include <cstring>
using namespace std;

class Vector
{
    char *name;
    int x, y, z;

public:
    Vector(char *n)
    {
        int l = strlen(n);
        name = new char[l + 1];
        strcpy(name, n);
        x = 0;
        y = 0;
        z = 0;
    }
    Vector(char *n, int a, int b, int c)
    {
        int l = strlen(n);
        name = new char[l + 1];
        strcpy(name, n);
        x = a;
        y = b;
        z = c;
    }

    Vector(const Vector &v)
    {
        int l = strlen(v.name);
        name = new char[l + 1];
        strcpy(name, v.name);
        x = v.x;
        y = v.y;
        z = v.z;
    }

    int setX(int a)
    {
        x = a;
    }

    int setY(int b)
    {
        y = b;
    }
    int setZ(int c)
    {
        z = c;
    }

    void setName(char *n)
    {
        int l = strlen(n);
        name = new char[l + 1];
        strcpy(name, n);
    }

    int getX()
    {
        return x;
    }

    int getY()
    {
        return y;
    }

    int getZ()
    {
        return z;
    }

    char *getName()
    {
        return name;
    }

    ~Vector()
    {
        delete[] name;
    }

    Vector operator=(Vector v)
    {
        int l = strlen(v.name);
        name = new char[l + 1];
        strcpy(name, v.name);
        x = v.x;
        y = v.y;
        z = v.z;
        return *this;
    }

    bool operator==(Vector v)
    {
        return ((x == v.x) && (y == v.y) && (z == v.z));
    }

    Vector operator^(Vector v)
    {
        Vector temp_v("Result1", y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x);
        return temp_v;
    }

    Vector operator*(Vector v)
    {
        Vector temp_v("Result1", x * v.x, y * v.y, z * v.z);
        return temp_v;
    }

    friend ostream &operator<<(ostream &output, Vector v);
    friend Vector operator*(Vector v, int i);
    friend Vector operator*(int i, Vector v);
};

ostream &operator<<(ostream &output, Vector v)
{

    output << noshowpos << v.name << ": " << v.x << "x" << showpos << v.y << "y" << v.z << "z\n";
    return output;
}

Vector operator*(Vector v, int i)
{
    Vector temp_v(v.name, i * v.x, i * v.y, i * v.z);
    return temp_v;
}

Vector operator*(int i, Vector v)
{
    Vector temp_v(v.name, i * v.x, i * v.y, i * v.z);
    return temp_v;
}

int main()
{
    Vector v1("v1", 1, 2, 3), v2("v2", 4, 5, -6), v3("Result1"), v4("Result2", -27, 18, -3);

    cout << v1; // Print the components of vector v1
    cout << v2; // Print the components of vector v2

    v3 = v1 ^ v2; // Calculate the cross product of vector v1 and vector v2 (Consider ^ as cross product for this assignment)
    cout << v3;   // Print the modified components of vector v3 (Name: Result1)

    if (v3 == v4) // Check for equality; if two vectors contain equal component values (x, y, z), then they are equal
        cout << "Vectors are equal" << endl;
    else
        cout << "Vectors are not equal" << endl;

    v1 = v1 * 2; // Multiply each component of vector v1 with the given value
    cout << v1;  // Print the modified components of vector v1

    v2 = 2 * v2; // Multiply each component of vector v2 with the given value
    cout << v2;  // Print the modified components of vector v2

    v3 = v1 * v2; // Multiply each component of vector v1 with the corresponding component of vector v2
    cout << v3;   // Print the modified components of vector v3 (Name: Result1)

    if (v3 == v4) // Check for equality; if two vectors contain equal component values (x, y, z), then they are equal
        cout << "Vectors are equal" << endl;
    else
        cout << "Vectors are not equal" << endl;

    return 0;
}

/* Output:
v1: 1x+2y+3z
v2: 4x+5y-6z
Result1: -27x+18y-3z
Vectors are equal
v1: 2x+4y+6z
v2: 8x+10y-12z
Result1: 16x+40y-72z
Vectors are not equal
*/
