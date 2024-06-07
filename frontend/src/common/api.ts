import Axios from 'axios';

class Api {
    static url = 'http://localhost:8080/backend/';

    static async get(path: string) {
        try {
            const response = await Axios.get(Api.url + path);
            console.log(`GET on "${Api.url + path}"`, {input: null, output: response});
            return response.data;
        } catch (e) {
            return null;
        }
    }
    static async post(path: string, obj: unknown) {
        try {
            const response = await Axios.post(Api.url + path, obj);
            console.log(`POST on "${Api.url + path}"`, {input: obj, output: response});
            return response.data;
        } catch (e) {
            return null;
        }
    }
    static async patch(path: string, obj: unknown) {
        try {
            const response = await Axios.patch(Api.url + path, obj);
            console.log(`PATCH on "${Api.url + path}"`, {input: obj, output: response});
            return response.data;
        } catch (e) {
            return null;
        }
    }
    static async delete(path: string) {
        try {
            const response = await Axios.delete(Api.url + path);
            console.log(`DELETE on "${Api.url + path}"`, {input: null, output: response});
            return response.data;
        } catch (e) {
            return null;
        }
    }

}

export default Api;
