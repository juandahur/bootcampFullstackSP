export interface Transactions {

    id: number;
    transactionType: string;
    description: string;
    value: number;
    destinationAccountId: number;
    operationType: string;
    createdAt: Date;
    createdBy: string;
    modifiedOn: Date;
    modifiedBy: string;
    products: [];

}
