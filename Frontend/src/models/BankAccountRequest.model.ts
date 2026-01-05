import { AccountStatus } from './AccountStatus.model';
import { AccountType } from './AccountType.model';

export interface BankAccountRequest {
  balance: number;
  createdAt: Date;
  status: AccountStatus;
  customerId: number;
  type: AccountType;
  extra: number;
}
