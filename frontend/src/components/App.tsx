import {useState} from 'react';
import Availability from './Availability';
import Confirmation from './Confirmation';
import {AvailabilityOutput, ConfirmationOutput} from '../common/types';


function App() {
  const [availabilityResponse, setAvailabilityResponse] = useState<AvailabilityOutput|undefined>(undefined);
  const [confirmationResponse, setConfirmationResponse] = useState<ConfirmationOutput|undefined>(undefined);
  return (<>
    {(availabilityResponse === undefined) && <Availability setResponse={setAvailabilityResponse}  />}
    {(availabilityResponse !== undefined && ! (confirmationResponse !== undefined)) && <Confirmation data={availabilityResponse} setResponse={setConfirmationResponse} />}
    {(confirmationResponse !== undefined) && <div className={'border mx-auto mt-3 card w-50'} style={{overflow: 'hidden'}}>
      <h6 className={'font-bold text-center bg-dark text-white my-0 p-2'}>{availabilityResponse?.requestId}</h6>
      <hr className={'my-0'} />
      <div className={'mt-2'}>
        {confirmationResponse.status === 'confirmed' && <>
          <div className={'d-block text-center'}>
            <b>Account Holder:</b>
            <label className={'ms-2'}>{confirmationResponse.accountHolder}</label>
          </div>
          <div className={'d-block text-center'}>
            <b>Invoice Number:</b>
            <label className={'ms-2'}>{confirmationResponse.invoiceNumber}</label>
          </div>
          <div className={'d-block text-center'}>
            <b>Amount Due:</b>
            <label className={'ms-2'}>{confirmationResponse.amountDue.toFixed(2)}$</label>
          </div>
        </>}
        <div className={'d-block text-center'}>
          <b>Request Status:</b>
          <label className={'ms-2'}>{confirmationResponse.status}</label>
        </div>
      </div>
      <button className={'d-block mx-auto btn btn-primary my-4'} onClick={e => window.location.reload()}>
        Go Back
      </button>
    </div>}
  </>);
}

export default App;
