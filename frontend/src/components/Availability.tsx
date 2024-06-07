import {Dispatch, SetStateAction, useState} from 'react';
import {AvailabilityInput, AvailabilityOutput} from '../common/types';
import Api from '../common/api';

type Props = {setResponse: Dispatch<SetStateAction<AvailabilityOutput|undefined>>};
function Availability(props: Props) {
    const {setResponse} = props;
    const [username, setUsername] = useState<string>('');
    const [cities, setCities] = useState<string[]>([]);
    const [price, setPrice] = useState<number>(0);
    const [height, setHeight] = useState<number>(0);
    const [width, setWidth] = useState<number>(0);

    return (<form className={'border mx-auto mt-3 card w-50'} style={{overflow: 'hidden'}} onSubmit={async e => {
        e.preventDefault();
        if(cities.length <= 0) {
            alert('You must chose at least one city!');
            return;
        }
        const obj: AvailabilityInput = {
            username,
            cities,
            price,
            posterFormat: `${height}x${width}`
        };
        const response = await Api.post('book', obj);
        if(response) setResponse(response);
        else alert('Error: Cannot connect to backend!');
    }}>
        <h6 className={'font-bold text-center bg-success text-white my-0 p-2'}>CHECK AVAILABILITY</h6>
        <hr className={'my-0'} />
        <div className={'d-flex p-2 mx-auto'}>
            <b className={'my-auto'}>Username</b>
            <input required={true} className={'ms-2 my-auto input'} type={'text'} onChange={e => setUsername(e.target.value)} />
        </div>

        <div className={'d-flex p-2 mx-auto'}>
            <div className={'d-block my-auto'}>
                <b className={'my-auto'}>Cities</b>
                <button className={'m-auto ms-2 btn btn-primary py-0 px-2'} style={{width: 'fit-content'}} onClick={e => {
                    const _cities = [...cities];
                    _cities.push('');
                    setCities(_cities);
                }}>
                    <i className={'bi bi-plus-lg'} />
                </button>
            </div>
            <div className={'d-block p-1'}>
                {cities.map((city, index) => <div key={index} className={'d-flex mt-1'}>
                    <input required={true} defaultValue={city} className={'d-block me-2'} type={'text'} onChange={e => {
                        const _cities = [...cities];
                        _cities[index] = e.target.value;
                        setCities(_cities);
                    }} />
                    <button className={'ms-auto btn btn-danger py-0 px-2'} onClick={e => {
                        const _cities = [...cities];
                        setCities(_cities.filter((c, i) => i !== index ));
                    }}>
                        <i className={'bi bi-trash3-fill'} />
                    </button><br />
                </div>)}
            </div>
        </div>

        <div className={'d-flex p-2 mx-auto'}>
            <b className={'my-auto'}>Maximum Price</b>
            <input required={true} className={'ms-2 my-auto input'} type={'number'} step={0.01} onChange={e => setPrice(Number(e.target.value))} />
        </div>
        <div className={'d-flex p-2 mx-auto'}>
            <b className={'my-auto'}>Poster Format (Height)</b>
            <input required={true} className={'ms-2 my-auto input'} type={'number'} onChange={e => setHeight(Number(e.target.value))}/>
        </div>
        <div className={'d-flex p-2 mx-auto'}>
            <b className={'my-auto'}>Poster Format (Width)</b>
            <input required={true} className={'ms-2 my-auto input'} type={'number'} onChange={e => setWidth(Number(e.target.value))}/>
        </div>
        <button type={'submit'} className={'d-block mx-auto btn btn-success my-4'}>
            SEND
        </button>
    </form>);
}

export default Availability;
