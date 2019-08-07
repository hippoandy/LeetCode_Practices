# ref. https://leetcode.com/problems/valid-phone-numbers/discuss/55481/Three-different-solutions-using-grep-sed-and-awk

# Read from the file file.txt and output all valid phone numbers to stdout.

## grep
# // Runtime: 8 ms, faster than 30.99% of Bash online submissions for Valid Phone Numbers.
# grep -P '^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$' file.txt
# grep -P '^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$' file.txt

## sed
# sed -n -r '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/p' file.txt

## awk
awk '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/' file.txt