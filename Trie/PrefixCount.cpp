#include<bits/stdc++.h>
using namespace std;
class TrieNode
{
	public:
	char ch;
	TrieNode* arr[26] = {};
	int pc;
	TrieNode(char ch)
	{
		this->ch = ch;
		pc = 0;
	}
};
class Trie
{
	TrieNode* root;
	public:
	Trie()
	{
		root = new TrieNode('/');
	}
	void insert()
	{
		string s;
		cout<<"Enter word\n";
		cin>>s;
		insert(s);		
	}
	void insert(string s)
	{
		TrieNode* p = root;
		int ind;
		for(int i = 0;s[i];i++)
		{
			ind = s[i] - 'a';
			if(p->arr[ind]==NULL)
			{
				p->arr[ind] = new TrieNode(s[i]);
			}
			p->arr[ind]->pc += 1;
			p = p ->arr[ind];
		}
	}
	bool search(string s)
	{
		int ind;
		TrieNode* p = root;
		for(int i = 0;s[i];i++)
		{
			ind = s[i] -'a'; 
			if(p->arr[ind] == NULL || p->arr[ind]->pc == 0)
			{
				return false; 
			}
			p = p->arr[ind];
		}
		return true;
	}
	void count()
	{
		string s;
		cout<<"Enter word\n";
		cin>>s;
		count(s);
	}
	void count(string s)
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
			cout<<"Number of words starting from "<<s<<" = "<<p->pc<<endl;
		}
		else
		{
			cout<<"Number of words starting from "<<s<<" = 0 \n";
		}

	}
	void deleteWord()
	{
		string s;
		cout<<"Enter word\n";
		cin>>s;
		deleteWord(s);
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
				p->arr[ind]->pc -= 1; 
				p = p->arr[ind];
			}
			cout<<"Word deleted\n";
		}
		else
		{
			cout<<"Word not present in dictionary\n";
		}

	}
};
int main()
{
	int x;
	Trie obj;
	do
	{
		cout<<"\n1.Insert\n2.Count Prefix\n3.Delete\n4.Exit\n";
		cin>>x;
		switch(x)
		{
			case 1: obj.insert();
				break;
			case 2: obj.count();
				break;
			case 3: obj.deleteWord();
				break;
			case 4: return 0;
		}
	}while(true);
	return 0;
}
