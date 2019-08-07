# Useful Linux Commands

## Count Unique files based on Number part

```bash
ls | awk -F'[_.]' '{print $1}' | uniq | wc -l
```