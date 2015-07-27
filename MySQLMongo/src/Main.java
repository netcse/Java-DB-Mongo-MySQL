/*
 * Copyright (c) 2008-2014 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import java.net.UnknownHostException;

public class Main {

    public static void main(final String[] args) throws UnknownHostException {
        MongoClientURI connectionString = new MongoClientURI("mongodb://192.168.1.11:27017");
        MongoClient mongoClient = new MongoClient(connectionString);

        MongoDatabase db = mongoClient.getDatabase("local");

        for(String i : mongoClient.listDatabaseNames()){
            System.out.println(i);
        }

        for(String i: db.listCollectionNames()){
            System.out.println(i);
        }

    }
}