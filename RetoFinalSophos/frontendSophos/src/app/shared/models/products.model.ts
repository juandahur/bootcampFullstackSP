export interface Products {
    id: number;
    accountType: string;
    accountNumber: string;
    productState: string;
    accountBalance: number;
    availableBalance: number;
    exemptGMT: boolean;
    createdAt: Date;
    createdBy: string;
    modifiedOn: Date;
    modifiedBy: string;
    clients: [];
    transactionsList:[];
}
