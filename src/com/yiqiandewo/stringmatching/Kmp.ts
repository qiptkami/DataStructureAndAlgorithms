function getNext(str: string): number[] {
  const next: number[] = [];
  let k = -1;
  let j = 0;
  next[0] = -1;
  const len = str.length;
  while (j < len - 1) {
    if (k === -1 || str.charAt(j) === str.charAt(k)) {
      j++;
      k++;
      next[j] = k;
    } else {
      k = next[k];
    }
  }
  return next;
}

function kmpSearch(s: string, p: string): boolean {
  const next = getNext(p);
  const sLen = s.length;
  const pLen = p.length;
  let i = 0;
  let j = 0;
  while (i < sLen && j < pLen) {
    if (j === -1 || s.charAt(i) === p.charAt(j)) {
      i++;
      j++;
    } else {
      j = next[j];
    }
  }
  return j === pLen;
}

const res = kmpSearch("abcdababcdabd", "abcdabde");
console.log(res);
