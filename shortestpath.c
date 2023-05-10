
#include <stdio.h>
#include <time.h>
#include <math.h>
void path(int selected, int lastnode[], int source){
printf("Path: ");
while(selected != source){
printf("%d -> ",selected);
selected = lastnode[selected];
}
printf("%d\n",source);
}
void minimumDistance(int selected, int nodes, int arr[][nodes], int mindist[], int visited[], int
lastnode[], int temp[]){
int ind, dist=99999;
for (int i=0;i<nodes;i++){
if (visited[i]==0){
int t = mindist[selected]+arr[selected][i];
if (t<mindist[i]){
mindist[i] = t;
lastnode[i] = selected;
}
if (mindist[i]<dist){
dist = mindist[i];
ind = i;
}
}
}
temp[0] = ind;
temp[1] = dist;
}
void djikstraSP(int nodes, int arr[][nodes], int source){
int visited[nodes], mindist[nodes], lastnode[nodes], selected = source, temp[3];
for (int i=0;i<nodes;i++){
visited[i] = 0;
lastnode[i] = selected;
mindist[i] = arr[selected][i];
}
for (int i=0;i<nodes-1;i++){
visited[selected] = 1;
minimumDistance(selected, nodes, arr, mindist, visited, lastnode, temp);
int ind = temp[0], dist = temp[1];
mindist[ind] = dist;
selected = ind;
printf("\nNext node: %d\nDistance from source: %d\n",ind, dist);
path(ind, lastnode, source);
}
  
}
int main()
{
int nodes;
printf("Enter number of nodes: ");
scanf(" %d",&nodes);
int arr[nodes][nodes];
for (int i=0;i<nodes;i++){
for (int j=i; j<nodes; j++){
if (i==j){
arr[i][j] = 0;
} else {
printf("Enter distance value between %d and %d: ",i,j);
scanf(" %d",&arr[i][j]);
}
arr[j][i] = arr[i][j];
}
}
for (int i=0;i<nodes;i++){
printf("[ ");
for (int j=0; j<nodes; j++){
printf(" %d, ",arr[i][j]);
}
printf("],\n");
}
  
djikstraSP(nodes,arr,0);
  
}