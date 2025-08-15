function separateFirstRest(firstArg, ...restArg) {
  return { firstArg, restArg };
}

console.log(separateFirstRest("movie", "RRR", "Bahubali", "Pushpa"));
