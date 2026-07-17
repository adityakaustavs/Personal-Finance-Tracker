export type TransactionType = 'INCOME' | 'EXPENSE';
export interface Transaction {id:number;type:TransactionType;amount:number;category:string;description:string;date:string}
export interface Budget {id:number;category:string;monthlyLimit:number;actualSpent:number;percentUsed:number;month:number;year:number}
export interface Summary {monthlyIncome:number;monthlyExpense:number;monthlyBalance:number;expensesByCategory:Record<string,number>;lastSixMonths:{label:string;income:number;expense:number}[]}
export interface AuthResponse {token:string;userId:number;username:string}
