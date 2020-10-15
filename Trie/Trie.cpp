#include<bits/stdc++.h>
using namespace std;
class TrieNode
{
	public:
	char ch;
	TrieNode* arr[26]={};
	int we;
	TrieNode(char ch)
	{
		this->ch = ch;
		we = 0;
	}
};
class Trie
{
	TrieNode* root;
	public:
	Trie()
	{
		root = new TrieNode('$');	
	}
	void insert()
	{
		string s;
		cout<<"Enter Word\n";
		cin>>s;
		insert(s);
		cout<<"Word Inserted in dictionary\n";
	}
	void insert(string arr)
	{
		TrieNode *p = root;
		for(int i = 0;arr[i];i++)
		{
			int ind = arr[i] - 'a';
			if(p->arr[ind]==NULL)
			{
				p->arr[ind] = new TrieNode(arr[i]);	
			}
			p = p->arr[ind];
		}
		p->we += 1;
	}
	void printAllWords(TrieNode* p,char *s,int pos = 0)
	{
   		if(p == NULL)
      			return;
		
		if(p->we>0)
		{
			for(int i = 0;i<pos;i++)
			{
				cout<<s[i];
			}
			cout<<endl;
			cout<<"Word count = "<<p->we<<endl;
		}
		   for(int i=0; i<26; i++)
		   {
		      if(p->arr[i] != NULL)
		      {
		      	 s[pos] =  p->arr[i]->ch;
			 printAllWords(p->arr[i],s, pos+1);
		      }
		   }
	}
	void print()
	{
		char arr[1000000];
		printAllWords(root,arr);
	}
	void search()
	{
		string s;
		cout<<"Enter Word\n";
		cin>>s;
		if(search(s))
		{
			cout<<"Word Present\n";
		}
		else
		{
			cout<<"Word not Present\n";
		}
	}
	bool search(string s)
	{
		TrieNode* p = root;
		int ind;
		for(int i = 0;s[i];i++)
		{
			ind = s[i] - 'a';
			
			if(p->arr[ind] == NULL)
				return false;
			p = p->arr[ind];
		}
		if(p->we == 0)
		{
			return false;
		}
		return true;
	}
	void deleteWord(string s)
	{
		if(search(s))
		{
			TrieNode* p = root;
			int ind;
			for(int i = 0;s[i];i++)
			{
				ind = s[i] - 'a';
				p = p->arr[ind];
			}
			p->we -= 1;
			cout<<"Word Deleted\n";
		}
		else
		{
			cout<<"Word not present in the dictionary\n";
		}
	}
	void deleteWord()
	{
		string s;
		cout<<"Enter Word\n";
		cin>>s;
		deleteWord(s);
		
	}
};
int main()
{
	Trie obj;
	int x;
	do
	{
		cout<<"\n1.Insert\n2.print\n3.search\n4.Delete\n5.Exit\n";
		cin>>x;
		switch(x)
		{
			case 1: obj.insert();
				break;
			case 2: obj.print();
				break;
			case 3: obj.search();
				break;
			case 4: obj.deleteWord();
				break;
			case 5: return 0;			
		}
	}while(true);
	return 0;
}
