import {useState} from "react";
import Availability from './Availability';
import Confirmation from './Confirmation';
import {AvailabilityOutput, ConfirmationOutput} from '../common/types';


function App() {
  const [availabilityResponse, setAvailabilityResponse] = useState<AvailabilityOutput|undefined>(undefined);
  const [confirmationResponse, setConfirmationResponse] = useState<ConfirmationOutput|undefined>(undefined);
  return (<>
    {(availabilityResponse === undefined) && <Availability setResponse={setAvailabilityResponse}  />}
    {(availabilityResponse !== undefined && ! (confirmationResponse !== undefined)) && <Confirmation data={availabilityResponse} setResponse={setConfirmationResponse} />}
    {(confirmationResponse !== undefined) && <div>
      {JSON.stringify(confirmationResponse)}
      <button onClick={e => window.location.reload()}>Go to HomePage</button>
    </div>}
  </>);
}

export default App;
