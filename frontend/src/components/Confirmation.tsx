import {AvailabilityOutput, ConfirmationInput, ConfirmationOutput} from "../common/types";
import {Dispatch, SetStateAction} from "react";

type Props = {data: AvailabilityOutput, setResponse: Dispatch<SetStateAction<ConfirmationOutput|undefined>>};
function Confirmation(props: Props) {
    const {data, setResponse} = props;
    return(<div>
        {JSON.stringify(data)}
        <button onClick={e => {
            const obj: ConfirmationInput = {
                requestId: data.requestId,
                decision: 'confirm'
            };
            setResponse({status: 'confirmed'});
        }}>CONFIRM</button>
        <button onClick={e => {
            const obj: ConfirmationInput = {
                requestId: data.requestId,
                decision: 'cancel'
            };
            setResponse({status: 'cancelled'});
        }}>CANCEL</button>
    </div>)
}

export default Confirmation;
