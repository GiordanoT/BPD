import {AvailabilityOutput, ConfirmationInput, ConfirmationOutput} from '../common/types';
import {Dispatch, SetStateAction} from 'react';
import Api from '../common/api';

type Props = {data: AvailabilityOutput, setResponse: Dispatch<SetStateAction<ConfirmationOutput|undefined>>};
function Confirmation(props: Props) {
    const {data, setResponse} = props;

    return (<div className={'border mx-auto mt-3 card w-50'} style={{overflow: 'hidden'}}>
        <h6 className={'font-bold text-center bg-dark text-white my-0 p-2'}>{data.requestId}</h6>
        <hr className={'my-0'} />
        <div className={'mt-2 d-flex'} style={{justifyContent: 'center'}}>
            <b>Available:</b>
            <div style={{width: '1.2em', height: '1.2em', borderRadius: '999px'}}
                 className={`d-block my-auto ms-1 ${data.available ? 'bg-success' : 'bg-danger'}`}>

            </div>
        </div>
        <div className={'mt-2'}>
            {data.zones.map((zone, index) => <div key={index} className={'d-block text-center'}>
                <b>Zone {index + 1}:</b>
                <label className={'ms-2'}>{zone.city}, {zone.name} ({zone.price}$)</label>
            </div>)}
        </div>
        <div className={'d-block text-center'}>
            <b>Total Price:</b>
            <label className={'ms-2'}>{data.price.toFixed(2)}$</label>
        </div>
        <div className={'d-flex'}>
            <button disabled={!(data.available) || data.zones.length <= 0} className={'d-block mx-auto btn btn-success my-4'} onClick={async e => {
                const obj: ConfirmationInput = {
                    requestId: data.requestId,
                    decision: 'confirm'
                };
                const response = await Api.post('decision', obj);
                if(response) setResponse(response);
            }}>CONFIRM</button>
            <button className={'d-block mx-auto btn btn-danger my-4'} onClick={async e => {
                const obj: ConfirmationInput = {
                    requestId: data.requestId,
                    decision: 'cancel'
                };
                const response = await Api.post('decision', obj);
                if(response) setResponse(response);
            }}>
                CANCEL
            </button>
        </div>

    </div>);
}

export default Confirmation;
