class BankAccount {
  constructor(accountNumber, balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  deposit(amount) {
    this.balance += amount;
    return `Balance is ${this.balance}`;
  }
  withdraw(amount) {
    if (amount > this.balance) {
      return `Insufficient balanace your balance is ${this.balance}`;
    } else {
      this.balance -= amount;
      return `amount ${amount} withdrawed.balance is ${this.balance}`;
    }
  }
}

let account = new BankAccount(12345, 1000);
console.log(account.deposit(500));
console.log(account.withdraw(300));
console.log(account.withdraw(10000));
