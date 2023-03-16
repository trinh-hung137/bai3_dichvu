import type { NextApiRequest, NextApiResponse } from "next";
// @ts-ignore
import axios from "axios";
import { xml2json } from "xml-js";
type Data = {
    name: string;
};
export default async function handler(
    req: NextApiRequest,
    res: NextApiResponse<Data>
) {
    if (req.method !== "POST") {
        return res.status(405).end(); // Method Not Allowed
    }
    const body = req.body;
