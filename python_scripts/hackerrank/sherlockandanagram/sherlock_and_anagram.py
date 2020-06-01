arr = ["abba", "abcd", "kkkkk" , "cdcd", "xyzx"]
ALPHABET = string.ascii_lowercase

for s in arr:
    signatures = {}

    # iterate over all substrings of s
    for i in range(len(s)):
        for j in range(0, len(s)-i):
            # generating substrings of size i+1
            substring = s[j:j+i+1]

            # initialize substring signature of fixed length 26
            # signature of anagram are same. Example xyz = yzx = (00000000000000000000000111)
            signature = [0 for _ in ALPHABET]
            for letter in substring:
                signature[ord(letter)-ord(ALPHABET[0])] += 1

            # tuples are hashable in contrast to lists so can be used as keys in the dictionary.
            signature = tuple(signature)
            signatures[signature] = signatures.get(signature, 0) + 1

    res = 0

    # Count of anagram pairs is n(n-1)/2
    # Example say xyz,zyx,yzx. So signature (xyz) = 3, so 3*2/2=3 i.e [(xyz,zyx),(xyz,yzx),(zyx,yzx)] combinations.
    # Another way to see above is to select combination of 2 pairs from 3 strings i.e 3C2 = 3
    for count in signatures.values():
        res += count*(count-1)/2
    print (res)