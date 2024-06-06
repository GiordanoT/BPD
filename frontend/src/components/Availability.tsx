import {Dispatch, SetStateAction, useState} from 'react';
import {AvailabilityInput, AvailabilityOutput} from '../common/types';

type Props = {setResponse: Dispatch<SetStateAction<AvailabilityOutput|undefined>>};
function Availability(props: Props) {
    const {setResponse} = props;
    const [username, setUsername] = useState<string>('');
    const [cities, setCities] = useState<string[]>([]);
    const [price, setPrice] = useState<number>(0);
    const [height, setHeight] = useState<number>(0);
    const [width, setWidth] = useState<number>(0);

    return (<div className={'border mx-auto mt-3 card w-50'} style={{overflow: 'hidden'}}>
        <h6 className={'font-bold text-center bg-success text-white my-0 p-2'}>CHECK AVAILABILITY</h6>
        <hr className={'my-0'} />
        <div className={'d-flex p-2 mx-auto'}>
            <b className={'my-auto'}>Username</b>
            <input className={'ms-2 my-auto input'} type={'text'} onChange={e => setUsername(e.target.value)} />
        </div>

        <div className={'d-flex p-2 mx-auto'}>
            <b className={'my-auto'}>Cities</b>
            <button className={'m-auto ms-2 btn btn-primary py-0 px-2'} style={{width: 'fit-content'}} onClick={e => {
                const _cities = [...cities];
                _cities.push('');
                setCities(_cities);
            }}>+</button><br />
            <div className={'d-block p-1'}>
                {cities.map((city, index) => <div key={index} className={'d-flex mt-1'}>
                    <input defaultValue={city} className={'d-block me-2'} type={'text'} onChange={e => {
                        const _cities = [...cities];
                        _cities[index] = e.target.value;
                        setCities(_cities);
                    }} />
                    <button className={'ms-auto btn btn-danger py-0 px-2'} onClick={e => {
                        const _cities = [...cities];
                        setCities(_cities.filter((c, i) => i !== index ));
                    }}>x</button><br />
                </div>)}
            </div>
        </div>

        <div className={'d-flex p-2 mx-auto'}>
            <b className={'my-auto'}>Maximum Price</b>
            <input className={'ms-2 my-auto input'} type={'number'} step={0.01} onChange={e => setPrice(Number(e.target.value))} />
        </div>
        <div className={'d-flex p-2 mx-auto'}>
            <b className={'my-auto'}>Poster Format (Height)</b>
            <input className={'ms-2 my-auto input'} type={'number'} onChange={e => setHeight(Number(e.target.value))}/>
        </div>
        <div className={'d-flex p-2 mx-auto'}>
            <b className={'my-auto'}>Poster Format (Width)</b>
            <input className={'ms-2 my-auto input'} type={'number'} onChange={e => setWidth(Number(e.target.value))}/>
        </div>
        <button className={'d-block mx-auto btn btn-success my-4'} onClick={e => {
            const obj: AvailabilityInput = {
                username,
                cities,
                price,
                posterFormat: `${height}x${width}`
            };
            setResponse({
                zones: [{id: '1', city: 'Rome', name: 'Colosseum', price: 5.3}],
                price: 10,
                requestId: 'ABC123'
            });
        }}>SEND</button>
    </div>);
}

export default Availability;
