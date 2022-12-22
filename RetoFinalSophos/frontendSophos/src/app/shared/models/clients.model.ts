export interface Clients {
    id: number;
    idDocument: string;
    idNumber: string;
    firstName: string;
    lastName: string;
    email: string;
    birthDate: Date;
    createdAt: Date;
    createdBy: string;
    modifiedOn: Date;
    modifiedBy: string;
    productsList:[];
}
