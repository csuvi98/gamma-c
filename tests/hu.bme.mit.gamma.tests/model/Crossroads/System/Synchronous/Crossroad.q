/*
controller: Priority -i-> prior: Green-->Yellow
*/
E<> sendingInteractionOfcontroller == 3 && receivingInteractionOfprior == 0 && isStable
/*
controller: Priority -i-> prior: Red-->Green
*/
E<> sendingInteractionOfcontroller == 3 && receivingInteractionOfprior == 4 && isStable
/*
controller: Priority -i-> prior: Yellow-->Red
*/
E<> sendingInteractionOfcontroller == 3 && receivingInteractionOfprior == 2 && isStable
/*
controller: SecondaryPrepares -i-> second: Yellow-->Red
*/
E<> sendingInteractionOfcontroller == 1 && receivingInteractionOfsecond == 6 && isStable
/*
controller: SecondaryPrepares -i-> second: Green-->Yellow
*/
E<> sendingInteractionOfcontroller == 1 && receivingInteractionOfsecond == 1 && isStable
/*
controller: SecondaryPrepares -i-> second: Red-->Green
*/
E<> sendingInteractionOfcontroller == 1 && receivingInteractionOfsecond == 3 && isStable
/*
controller: Priority -i-> second: Yellow-->Red
*/
E<> sendingInteractionOfcontroller == 3 && receivingInteractionOfsecond == 6 && isStable
/*
controller: Priority -i-> second: Green-->Yellow
*/
E<> sendingInteractionOfcontroller == 3 && receivingInteractionOfsecond == 1 && isStable
/*
controller: Priority -i-> second: Red-->Green
*/
E<> sendingInteractionOfcontroller == 3 && receivingInteractionOfsecond == 3 && isStable
/*
controller: Secondary -i-> second: Yellow-->Red
*/
E<> sendingInteractionOfcontroller == 2 && receivingInteractionOfsecond == 6 && isStable
/*
controller: Secondary -i-> second: Green-->Yellow
*/
E<> sendingInteractionOfcontroller == 2 && receivingInteractionOfsecond == 1 && isStable
/*
controller: Secondary -i-> second: Red-->Green
*/
E<> sendingInteractionOfcontroller == 2 && receivingInteractionOfsecond == 3 && isStable
/*
controller: Operating-->Operating -i-> second: Interrupted-->Normal
*/
E<> sendingInteractionOfcontroller == 5 && receivingInteractionOfsecond == 8 && isStable
/*
controller: Operating-->Operating -i-> second: Normal-->Interrupted
*/
E<> sendingInteractionOfcontroller == 5 && receivingInteractionOfsecond == 5 && isStable
/*
controller: Init -i-> prior: Green-->Yellow
*/
E<> sendingInteractionOfcontroller == 0 && receivingInteractionOfprior == 0 && isStable
/*
controller: Init -i-> prior: Red-->Green
*/
E<> sendingInteractionOfcontroller == 0 && receivingInteractionOfprior == 4 && isStable
/*
controller: Init -i-> prior: Yellow-->Red
*/
E<> sendingInteractionOfcontroller == 0 && receivingInteractionOfprior == 2 && isStable
/*
controller: PriorityPrepares -i-> prior: Green-->Yellow
*/
E<> sendingInteractionOfcontroller == 4 && receivingInteractionOfprior == 0 && isStable
/*
controller: PriorityPrepares -i-> prior: Red-->Green
*/
E<> sendingInteractionOfcontroller == 4 && receivingInteractionOfprior == 4 && isStable
/*
controller: PriorityPrepares -i-> prior: Yellow-->Red
*/
E<> sendingInteractionOfcontroller == 4 && receivingInteractionOfprior == 2 && isStable
/*
controller: Operating-->Operating -i-> prior: Normal-->Interrupted
*/
E<> sendingInteractionOfcontroller == 5 && receivingInteractionOfprior == 7 && isStable
/*
controller: Operating-->Operating -i-> prior: Interrupted-->Normal
*/
E<> sendingInteractionOfcontroller == 5 && receivingInteractionOfprior == 9 && isStable
/*
controller: Secondary -i-> prior: Green-->Yellow
*/
E<> sendingInteractionOfcontroller == 2 && receivingInteractionOfprior == 0 && isStable
/*
controller: Secondary -i-> prior: Red-->Green
*/
E<> sendingInteractionOfcontroller == 2 && receivingInteractionOfprior == 4 && isStable
/*
controller: Secondary -i-> prior: Yellow-->Red
*/
E<> sendingInteractionOfcontroller == 2 && receivingInteractionOfprior == 2 && isStable
