def palindrome(string):
        start = 0
        end = len(string)-1
        while (start < end):
            if string[start] == string[end]:
                start += 1
                end -= 1
            else:
                return False
        return True

def longestPalindrome(s: str) -> str:

    # Sldiing Window Check
    n = len(s)

    for length in range(n,0,-1):
        start = 0
        print("windowSize",length)
        while (start+length < n):
            string = s[start:start+length+1]
            print(s,string,start,start+length)
            if palindrome(string):
                return string
            start += 1
    return s[0]
                
print(longestPalindrome("abccba"))
