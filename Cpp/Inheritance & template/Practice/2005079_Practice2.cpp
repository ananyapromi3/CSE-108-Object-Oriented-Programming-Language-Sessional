# include <iostream>
# include <typeinfo>
# include <cmath>
# include <cstdlib>

using namespace std;

#define X double
#define type "double"

/* Output for     #define X int
                  #define type "int"

    shape <int> object: 2
    square <int> object: 9    length: 3
    cube <int> object: 8    length: 2


    Generating random objects .

    cube <int> object.   volume: 343
    square <int> object.   Area: 0
    cube <int> object.   volume: 64
    square <int> object.   Area: 324
    square <int> object.   Area: 16


Output for        #define X double
                  #define type "double"

    shape <double> object: 2.3
    square <double> object: 9    length: 3
    cube <double> object: 8    length: 2

    Generating random objects .

    cube <double> object.   volume: 343
    square <double> object.   Area: 0
    cube <double> object.   volume: 64
    square <double> object.   Area: 324
    square <double> object.   Area: 16

*/



template <class T>
class shape
{

public:
    T value;
    shape(T n)
    {
        value = n;
    }
    //Write down a virtual function get_val() here
    virtual T get_val() { return this->value; }
};

//Write a generic "square" class here that inherits "shape" class
template <class T>
class square : public shape<T>
{

public:
    square(T value) : shape<T>(value) {}
    T get_val() { return (this->value * this->value); }
};

//Write a generic "cube" function here that inherits "shape" class
template <class T>
class cube : public shape<T>
{
public:
    cube(T value) : shape<T>(value) {}
    T get_val() { return (this->value * this->value * this->value); }
};



template <class T>
shape <T> * generator ()
{
    switch ( rand () % 2)
    {
    case 0:
        return new square <T> ( rand () % 20) ;
    case 1:
        return new cube <T> ( rand () % 10) ;
    }
    return NULL;
}

int main()
{
    shape <X> ob1(2.3), *ps;
    square <X> ob2(3);
    cube <X> ob3(2);


    //write necessary codes to generate the appropriate output.

    ps = &ob1;
    cout << "shape <" << type << "> object: " << ps->get_val() << endl; //    shape <double> object: 2.3
    ps = &ob2;
    cout << "square <" << type << "> object: " << ps->get_val() << "\tlength: " << ps->value << endl; //    square <double> object: 9    length: 3
    ps = &ob3;
    cout << "cube <" << type << "> object: " << ps->get_val() << "\tlength: " << ps->value << endl; //    cube <double> object: 8    length: 2
    cout << endl;

    cout << "Generating random objects .\n" << endl;
    for (int i=0; i <5; i++)
    {
        ps = generator<X>(); // get next object

        try
        {
            if( typeid (*ps) == typeid(square <X>)) throw 1;
            if( typeid (*ps) == typeid(cube <X>)) throw 2;
        }


        //Write down necessary codes under "catch" codes here to generate appropriate output
        catch (int i)
        {
            if(i == 1)
                cout << "square <" << type << "> object.   Area: " << ps->get_val() << endl;
            else
                cout << "cube <" << type << "> object.   volume: " << ps->get_val() << endl;
        }

    }
    return 0;
}
