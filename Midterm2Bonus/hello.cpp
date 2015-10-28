#include <iostream>
#include <string>

using std::string;
using std::cout;
using std::endl;

int main()
{
   cout << "Hey,";
   string mesg = "this my second C++ program";
   mesg += "!";
   cout << mesg << endl;
 
  // endl stands for 'end line'

   for(int i=0; i<16; i++) {
	for(int j=0; j<16; j++){
    	 cout << i*j;
    	 cout << "\t";
	}
	cout << endl;
   }
   return 0;
}
