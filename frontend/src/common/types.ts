export type AvailabilityInput = {
    username: string,
    cities: string[],
    price: number,
    posterFormat: string
}

export type Zone = {
    id: string,
    name: string,
    city : string,
    price: number
}

export type AvailabilityOutput = {
    zones: Zone[],
    price: number,
    requestId: string
};

export type ConfirmationInput = {
    requestId: string,
    decision: string
};

export type ConfirmationOutput = {
    accountHolder: string,
    invoiceNumber: string,
    amountDue: number,
    status: string
};
